//package v2.logic;
//
//import jakarta.persistence.AttributeConverter;
//import jakarta.persistence.Converter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@Converter
//public class PasswordConverter implements AttributeConverter<String, String> {
//
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    @Override
//    public String convertToDatabaseColumn(String attribute) {
//        return bCryptPasswordEncoder.encode(attribute);
//    }
//
//    @Override
//    public String convertToEntityAttribute(String dbData) {
//        return dbData;
//    }
//}