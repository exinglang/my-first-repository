import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testRandom();
	}

	private void testLag() {
		String lost = new String();
		String delay = new String();
		Process p;
		try {
			p = Runtime.getRuntime().exec(
					"ping -c 4 " + "www.badfdfdgggsasdfsdfsdfsdfidu.com");

			BufferedReader buf = new BufferedReader(new InputStreamReader(
					p.getInputStream()));
			String str = new String();
			while ((str = buf.readLine()) != null) {
				if (str.contains("packet loss")) {
					int i = str.indexOf("received");
					int j = str.indexOf("%");
					System.out.println("丢包率:" + str.substring(i + 10, j + 1));
					// System.out.println("丢包率:"+str.substring(j-3, j+1));
					lost = str.substring(i + 10, j + 1);
				}
				if (str.contains("avg")) {
					int i = str.indexOf("/", 20);
					int j = str.indexOf(".", i);
					System.out.println("延迟:" + str.substring(i + 1, j));
					delay = str.substring(i + 1, j);
					delay = delay + "ms";
					System.out.println("延迟:" + delay);
				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void testRandom() {
		int x = 1 + (int) (Math.random() * 2);
		System.out.println(x + "");
	}
}
