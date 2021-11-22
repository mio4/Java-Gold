//存疑代码....

class DynamicFieldsException extends Exception {}
public class DynamicFields {
	private Object[][] fields;
	public DynamicFields(int initializeSize){
		fields = new Object[initializeSize][2];
		for(int i=0;i < initializeSize; i++){
			fields[i] = new Object[][] {null, null};
		}
	}

	public String toString(){
		StringBuilder result = new StringBuilder();
		for(Object[] obj : fields){
			result.append(obj[0]);
			result.append(":");
			result.append(obj[1]);
			result.append("\n");
		}
		return result.toString();
	}

	private int hasField(String id){
		for(int i=0;i < fields.length;i++)
			if(id.equals(fields[i][0]))
				return 1;
		return -1;
	}
	private int getFieldNumber(String id) throws NoSuchFieldException {
		int fieldNum = hasField(id);
		if(fieldNum == -1)
			throw new NoSuchFieldException(); //
		return fieldNum;
	}
	private int makeField(String id){
		for(int i=0;i < fields.length;i++){
			if(fields[i][0] == null) {
				//存疑：为什么Object[] 数组不能存储String类型对象
				fields[i][0] = id;
				return i;
			}
		}
		//No empty fields, make one
		Object[][] tmp = new Object[fields.length+1][2];
		for(int i=0; i < fields.length; i++)
			tmp[i] = fields[i];
		for(int i=fields.length; i < tmp.length; i++)
			tmp[i] = new Object[] {null, null};
		fields = tmp;
		return makeField(id);
	}

	public Object getField(String id) throws NoSuchFieldException {
		return fields[getFieldNumber(id)][1];
	}

	public Object setField(String id, Object value) throws DynamicFieldsException{
		if(value == null){
			DynamicFieldsException dfe = new DynamicFieldsException();
			dfe.initCause(new NullPointerException());
			throw dfe;
		}
		int fieldNumber = hasField(id);
		if(fieldNumber == -1)
			fieldNumber = makeField(id);
		Object result = null;
		try {
			result = getField(id);
		} catch (NoSuchFieldException e){
			throw new RuntimeException();
		}
		fields[fieldNumber][1] = value;
		return result;
	}
	public static void main(String[] args){
		DynamicFields df = new DynamicFields(3);
		System.out.println(df);
		try {
			df.setField("d","A value for d");
			df.setField("number",47);
			df.setField("number2",48);
			System.out.println(df);
			df.setField("d","A value for new d");
			df.setField("number3",49);
			System.out.println("df :" + df);
			System.out.println("df.getField(\"d\":" + df.getField("d"));
			Object field = df.setField("d",null);
		} catch (NoSuchFieldException e){
			e.printStackTrace(System.out);
		} catch (DynamicFieldsException e){
			e.printStackTrace(System.out);
		}
	}
}
