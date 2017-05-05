
public class TimeLength {
	private String[] hms = new String[3];
	private int seconds;
	private boolean sign = true;
	static String[] secToHMS(int seconds)
	{
		String[] hms = new String[3];
		seconds=Math.abs(seconds);
		if (seconds / 3600 > 0) {
			int t;
			if ((seconds / 3600) < 10)
				hms[0] = "0" + String.valueOf(seconds / 3600);
			else
				hms[0] = String.valueOf(seconds / 3600);
			t = seconds % 3600;
			if (t / 60 > 0) {
				if (t / 60 < 10)
					hms[1] = "0" + String.valueOf(t / 60);
				else
					hms[1] = String.valueOf(t / 60);
				if (t % 60 < 10)
					hms[2] = "0" + String.valueOf(t % 60);
				else
					hms[2] = String.valueOf(t % 60);
			} else {
				if (t < 10)
					hms[2] = "0" + String.valueOf(t);
				else
					hms[2] = String.valueOf(t);
				hms[1] = "00";
			}
		} else if (seconds / 60 > 0) {
			hms[0] = "00";
			if ((seconds / 60) < 10)
				hms[1] = "0" + String.valueOf(seconds / 60);
			else
				hms[1] = String.valueOf(seconds / 60);
			if ((seconds % 60) < 10)
				hms[2] = "0" + String.valueOf(seconds % 60);
			else
				hms[2] = String.valueOf(seconds % 60);

		} else {
			hms[0] = "00";
			hms[1] = "00";
			if (seconds < 10)
				hms[2] = "0" + String.valueOf(seconds);
			else
				hms[2] = String.valueOf(seconds);
		}
		return hms;
	}
	static int HMTToSec(String[] hms)
	{	
		int seconds = ((Integer.parseInt(hms[0])) * 60 + (Integer.parseInt(hms[1]))) * 60 + (Integer.parseInt(hms[2]));
		return seconds;
	}
	TimeLength(int sec) {
		seconds = sec;
		if (sec < 0) {
			sign = false;
		}
		this.hms=secToHMS(sec);
	}

	TimeLength(String[] hms, boolean sign) {
		this.sign = sign;
		this.hms =secToHMS( HMTToSec(hms));
		if(sign)
			this.seconds=HMTToSec(hms);
		else
			this.seconds=-HMTToSec(hms);
		if(this.seconds<0)
			this.sign=false;
	}

	void adjustHMS(String[] h, boolean sign) {
		int secChange=HMTToSec(h);
		if(sign)
			this.seconds=this.seconds+secChange;
		else
			this.seconds=this.seconds-secChange;
		this.hms=secToHMS(this.seconds);
		if(this.seconds<0)
			this.sign=false;
	}

	void adjustSec(int sec) {
		seconds = seconds + sec;
		this.hms=secToHMS(this.seconds);
	}

	String getHMS() {
		String i;
		if (!sign)
			i = "-" + hms[0] + ":" + hms[1] + ":" + hms[2];
		else
			i = hms[0] + ":" + hms[1] + ":" + hms[2];
		return i;
	}

	int getSeconds() {

		return seconds;
	}
}
