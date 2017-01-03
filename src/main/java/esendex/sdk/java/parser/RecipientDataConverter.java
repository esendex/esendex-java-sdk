package esendex.sdk.java.parser;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class RecipientDataConverter implements Converter {

    public boolean canConvert(Class clazz) {
        return AbstractMap.class.isAssignableFrom(clazz);
    }

    @Override
    public void marshal(Object o, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {

    }

    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {

        Map<String, String> map = new HashMap<>();

        while(reader.hasMoreChildren()) {
            String key = "", value = "";
            reader.moveDown();

            while(reader.hasMoreChildren()) {
                reader.moveDown();

                String nodeName = reader.getNodeName();

                if (nodeName.equals("key")) {
                    key = reader.getValue();
                }
                else {
                    value = reader.getValue();
                }

                reader.moveUp();
            }

            map.put(key, value);
            reader.moveUp();
        }

        return map;
    }
}
