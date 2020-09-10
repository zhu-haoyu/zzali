package com.zz.ejlchina.okhttps.internal;

import com.zz.ejlchina.okhttps.Process;

public class RealProcess implements Process {

	// 总字节数
	private long totalBytes;
	// 已经完成字节数
	private long doneBytes;
	
	
	public RealProcess(long totalBytes, long doneBytes) {
		this.totalBytes = totalBytes;
		this.doneBytes = doneBytes;
	}
	
	@Override
	public double getRate() {
		return (double) doneBytes / totalBytes;
	}

	@Override
	public long getTotalBytes() {
		return totalBytes;
	}

	@Override
	public long getDoneBytes() {
		return doneBytes;
	}
	
	@Override
	public boolean isDone() {
		return doneBytes >= totalBytes;
	}
	
	public void addDoneBytes(long delt) {
		doneBytes += delt;
	}
	
	public void increaseDoneBytes() {
		doneBytes++;
	}
	
	public boolean notDoneOrReached(long bytes) {
		return doneBytes < bytes && doneBytes < totalBytes;
	}

}
