
package esendex.sdk.java.parser;

import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.enums.EnumConverter;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import esendex.sdk.java.model.types.Status;

/**
 * An Enum converter that converts xml element to Enum insensitive to case.
 * Enum to XML element conversion relies on Enum.toString() implementation.
 * 
 * @author Mike Whittaker
 */
public class EsendexCasedEnumConverter extends EnumConverter {

	/**
	 * Enum to XML element conversion that relies on Enum.toString()
	 * implementation.
	 * @param source the source
	 * @param writer the writer
	 * @param context the context
	 */
    @SuppressWarnings("unchecked")
	public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
    	
    	Enum enuum = (Enum) source; 	
    	String value;
    	
    	String toString = enuum.toString();
    	
    	value = toString;
    	
//    	String name = enuum.name();
//    	if (name.equals(toString)) {
//    		value = toTitleCase(name);
//    	} else {
//    		value = toString;
//    	}
    	
        writer.setValue(value);
    }

    /**
	 * Converts XML element to Enum insensitive to case. Specifically, the
	 * element value is converted to uppercase and matched against available
	 * Enum values. This has the side effect that Enums must follow Java coding
	 * conventions and be declared in uppercase.
	 * @param reader the reader
	 * @param context the context
	 * @return the object
	 */
    @SuppressWarnings("unchecked")
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        Class type = context.getRequiredType();
        if (type.getSuperclass() != Enum.class) {
            type = type.getSuperclass(); // polymorphic enums
        }       
        Status.values();
        return Enum.valueOf(type, reader.getValue().toUpperCase());
    }
    
    // TODO - remove if not required
	@SuppressWarnings("unused")
	private static String toTitleCase(String name) {
		if (name == null || name.length() == 0) return name;
		char[] chrs = name.toLowerCase().toCharArray();
		chrs[0] = Character.toUpperCase(chrs[0]);
		String out = new String(chrs).intern();
		return out;
	}


}
