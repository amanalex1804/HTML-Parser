                      // HTMLParser.java

package dime;
//like the consumer in producer-consumer problem
/*
 * demi_god & SS27
 */
public class HTMLParser implements Runnable{
Buffer buff;
String parsed;
public HTMLParser(Buffer b){
	this.buff=b;
	Thread t=new Thread(this);
	t.start();
}
@Override
public void run() {
	
	buff.parser();
}
}