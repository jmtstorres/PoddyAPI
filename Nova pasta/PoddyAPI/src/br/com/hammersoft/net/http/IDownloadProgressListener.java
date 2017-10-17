package br.com.hammersoft.net.http;

public interface IDownloadProgressListener {
	void started(long size);
	void updated(int progress);
	void complete();
	void failed(int reason);
}
