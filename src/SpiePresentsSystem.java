import java.util.*;
class Main {
	
	public static void main(String[] args) {

		ArrayList<String> encodedMessages = new ArrayList<String>();

		Map<Character, Character> decodingMap = buildDecodingMap();

		String s1 = "Nintendo Switch";
		String s2 = "LEGO Batman & Robin set";
		String s3 = "XBOX 360";
		String s4 = "PS4";
		String s5 = "Air";
		String s6 = "Vacation";

		encodedMessages.add(encode(decodingMap, s1));
		encodedMessages.add(encode(decodingMap, s2));
		encodedMessages.add(encode(decodingMap, s1));
		encodedMessages.add(encode(decodingMap, s6));

		Map<String, Integer> res = spiesGifts(decodingMap, encodedMessages);

		System.out.println(res.get(s1));
	}
	
	/*Method to decode the given Strings in the Array List provided that represents 
	 *the encoded messages from the spies
	 */
	
	private static Map<Character, Character> buildDecodingMap(){

		HashMap<Character, Character> res = new HashMap<Character, Character>();

		for(char c = 0; c<= 127; c++){
			res.put(Character.valueOf(c), Character.valueOf((char)(127-(c))) );
		}
		
		return res;
	}


	// Helper for problems, default method to encode the given Strings so they can later be decoded
	private static String encode(Map<Character, Character> dict, String stringToDecode){
		
		StringBuilder result = new StringBuilder();
		
		HashMap<Character, Character> encodeDict = new HashMap<Character, Character>();
		
		for(Character c: dict.keySet() ){
			encodeDict.put(dict.get(c),c);
		}
		
		for(char c: stringToDecode.toCharArray()){
			result.append(dict.get(c));
		}
		
		return result.toString();
	}

	public static Map<String, Integer> spiesGifts(Map<Character, Character> decodeMap, List<String> encodedMessages){
		
		HashMap<String, Integer> result = new HashMap<String, Integer>();

		for(String s : encodedMessages){
			
			StringBuilder decodedItemBuilder = new StringBuilder();
			//String decodedString = "";
			
			for(char c: s.toCharArray()){
				decodedItemBuilder.append(decodeMap.get(c));
				//decodedString = decodedString + c;
			}

			String decodedItem = decodedItemBuilder.toString();

			if(result.containsKey(decodedItem)){
				
				// Get the previous number in the hash map and add one
				int previousNumber = result.get(decodedItem);
				
				result.put(decodedItem, previousNumber + 1);
				
			}else{
				result.put(decodedItem, 1);
			}
		}

		return result;
	}
}
