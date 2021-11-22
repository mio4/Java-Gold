public class WStringBuilder {
	public String implicit(String[] fields){
		String result = "";
		for(int i=0; i < fields.length; i++)
			result += fields;
		return result;
	}
	public String explicit(String[] fields){
		StringBuilder result = new StringBuilder();
		for(int i=0; i < fields.length; i++)
			result.append(fields[i]);
		return result.toString();
	}
}
