/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

/**
 *
 * @author lennyasus
 */
public class Download {
	
	private int downloadId;
	private String downloadFunStuff;
        private int worldId;

	/**
	 * @return the downloadId
	 */
	public int getDownloadId() {
		return downloadId;
	}

	/**
	 * @param downloadId the downloadId to set
	 */
	public void setDownloadId(int downloadId) {
		this.downloadId = downloadId;
	}

	/**
	 * @return the downloadFunStuff
	 */
	public String getDownloadFunStuff() {
		return downloadFunStuff;
	}

	/**
	 * @param downloadFunStuff the downloadFunStuff to set
	 */
	public void setDownloadFunStuff(String downloadFunStuff) {
		this.downloadFunStuff = downloadFunStuff;
	}

    /**
     * @return the worldId
     */
    public int getWorldId() {
        return worldId;
    }

    /**
     * @param worldId the worldId to set
     */
    public void setWorldId(int worldId) {
        this.worldId = worldId;
    }
	
}
