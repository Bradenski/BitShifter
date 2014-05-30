//Code to convert to ASCII from a binary string, decimal string, or hex string. 

public class ASCIIDecoder {
	
	public String intToASCII(int decimal) {
		String ASCII = Character.toString((char) decimal);
		return ASCII;
	}
	
	public String binaryToASCII(String binary) {
		String ASCII = Character.toString((char) Integer.parseInt(binary, 2));		
		return ASCII;
	}
	
	public String hexToASCII(String hex) {
		String ASCII = Character.toString((char) Integer.parseInt(hex,16));		
		return ASCII;
	}
}
