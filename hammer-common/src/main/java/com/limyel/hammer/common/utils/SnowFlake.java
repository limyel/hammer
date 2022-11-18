package com.limyel.hammer.common.utils;

import com.limyel.hammer.common.exception.HammerException;
import com.limyel.hammer.common.exception.error.ErrorCode;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Data
@Component
public class SnowFlake {

    private long workerId = 1;

    private long datacenterId = 1;

    private long sequence = 0L;

    private long twepoch = 1579400598000L;

    private long workerIdBits = 5L;

    private long datacenterIdBits = 5L;

    private long sequenceBits = 12L;

    private long maxWorkerId;

    private long maxDatacenterId;

    private long workerIdShift = sequenceBits;

    private long datacenterIdShift = sequenceBits + workerIdBits;

    private long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;

    private long sequenceMask = ~(-1L << sequenceBits);

    private long lastTimestamp = -1L;

    @PostConstruct
    private void init() {
        this.maxWorkerId = ~(-1L << this.workerIdBits);
        this.maxDatacenterId = ~(-1L << this.datacenterIdBits);
        if ((this.datacenterId > this.maxDatacenterId || this.datacenterId < 0)
                || (this.workerId > this.maxWorkerId || this.workerId < 0)) {
            throw new HammerException(ErrorCode.SNOW_FLAKE_DATACENTER_WORKER_ID_ERROR);
        }
    }

    public synchronized String nextId() {
        long timestamp = System.currentTimeMillis();
        if (timestamp < this.lastTimestamp) {
            throw new HammerException(ErrorCode.SNOW_FLAKE_TIMESTAMP_ERROR);
        }

        if (timestamp == this.lastTimestamp) {
            this.sequence = (this.sequence + 1) & this.sequenceMask;
            if (this.sequence == 0) {
                timestamp = tilNextMillis(this.lastTimestamp);
            }
        } else {
            this.sequence = 0L;
        }
        this.lastTimestamp = timestamp;

        long token = ((timestamp - this.twepoch) << this.timestampLeftShift)
                | (this.datacenterId << this.datacenterIdShift)
                | (this.workerId << this.workerIdShift)
                | this.sequence;
        return String.valueOf(token);
    }

    protected long tilNextMillis(long lastTimestamp) {
        long timestamp = System.currentTimeMillis();
        while (timestamp <= lastTimestamp) {
            timestamp = System.currentTimeMillis();
        }
        return timestamp;
    }
}
