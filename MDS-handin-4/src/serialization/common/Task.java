package serialization.common;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import serialization.Serializer;

public class Task {
    @XmlAttribute
    public String id;
    @XmlAttribute
    public String name;
    @XmlAttribute
    public String date;
    @XmlAttribute
    public String status;
    @XmlElement
    public String description;
    @XmlElement
    public String attendants;
    public String required;
    public String responses;
    public String conditions;
    
    public Task() {
        id = null;
        name = null;
        date = null;
        status = null;
        description = null;
        attendants = null;
        required = null;
        responses = null;
        conditions = null;        
    }
    
}
