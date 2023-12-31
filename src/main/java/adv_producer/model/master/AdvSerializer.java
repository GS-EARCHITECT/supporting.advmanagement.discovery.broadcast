package adv_producer.model.master;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

public class AdvSerializer implements Serializer<AdvMaster_DTO> 
{
	private ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
	}

	 @Override
	    public byte[] serialize(String topic, AdvMaster_DTO data) {
	        try {
	            if (data == null){
	                System.out.println("Null received at serializing");
	                return null;
	            }
	            System.out.println("Serializing...");
	            return objectMapper.writeValueAsBytes(data);
	        }
	        catch (Exception e) 
	        {
	            throw new SerializationException("Error when serializing MessageDto to byte[]");
	        }
	 }
	
	@Override
	public void close() {
	}

}
