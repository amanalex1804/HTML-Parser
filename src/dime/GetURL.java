                  //         GetURL.java


package dime;
/*
 * demi_god & SS27
 */
//like the producer in producer-consumer problem

public class GetURL implements Runnable {
	Buffer buff;
	String url;
	GetURL(Buffer b,String u){
		this.buff=b;
		this.url=u;
		Thread t=new Thread(this);
		t.start();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		buff.getSourceCode(url);
	}

	}
