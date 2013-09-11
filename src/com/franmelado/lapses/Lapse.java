package com.franmelado.lapses;

public class Lapse {

	/**
	 * Class variables definition
	 */ 
	
	private int ssd, ssi, fmd, fmf, pt, scale;
	private String loc;
	
	/**
	* Class constructors
	*/ 
	
	// General constructor
	public Lapse(int scale, int ssd, int ssi, int fmd, int fmf) {
		this.scale = scale;
		this.ssd = ssd;
		this.ssi = ssi;
		this.fmd = fmd;
		this.fmf = fmf;
		this.pt = ssd / ssi;
	}
	
	// Default constructor
	public Lapse() {
		this.scale = 2;
		this.ssd = 600;
		this.ssi = 5;
		this.fmd = 5;
		this.fmf = 24;
		this.pt = 600 / 5;
	}


	/**
	 * Getters and Setters
	 * Includes methods for calculating different variables
	 */
	
	// @return the scale
		public int getScale() {
			return scale;
		}

		// @param ssd the scale to set
		public void setScale(int scale) {
			this.scale = scale;
		}
	
	// @return the ssd
	public int getSsd() {
		return ssd;
	}

	// @param ssd the ssd to set
	public void setSsd(int ssd) {
		this.ssd = ssd;
	}

	// return the ssi
	public int getSsi() {
		return ssi;
	}

	// @param ssi the ssi to set
	public void setSsi(int ssi) {
		this.ssi = ssi;
	}

	// @return the fmd
	public int getFmd() {
		return fmd;
	}

	// @param fmd the fmd to set
	public void setFmd(int fmf) {
		this.fmf = fmf;
		this.fmd = pt / fmf;
	}

	// @return the fmf
	public int getFmf() {
		return fmf;
	}

	// @param fmf the fmf to set
	public void setFmf(int fmd) {
		this.fmd = fmd;
		this.fmf = pt / fmd;
	}

	// @return the pt
	public int getPt() {
		return pt;
	}

	// @param pt the pt to set
	public void setPt(int ssd, int ssi) {
		this.ssd = ssd;
		this.ssi = ssi;
		this.pt = ssd / ssi;
	}

	// @return the loc
	public String getLoc() {
		return loc;
	}

	// @param loc the loc to set
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	// Function to format lapses of time
	public String formatS(int seconds) {
		int h = seconds / 3600;
		int min = (seconds - h * 3600) / 60;
		int s = seconds - h * 3600 - min * 60;
		return (seconds < 60 ? (s + " s")
			: (seconds >= 60 && seconds < 3600) ? (min + " min " + s + " s")
			: seconds >= 3600 ? (h + " h " + min + " min " + s + " s")
			: "Error");
	}
	
}
