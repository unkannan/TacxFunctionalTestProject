 package APIFrame.model;
 
 import java.util.HashMap;
 import java.util.Map;
 import com.fasterxml.jackson.annotation.JsonAnyGetter;
 import com.fasterxml.jackson.annotation.JsonAnySetter;
 import com.fasterxml.jackson.annotation.JsonIgnore;
 import com.fasterxml.jackson.annotation.JsonInclude;
 import com.fasterxml.jackson.annotation.JsonProperty;
 import com.fasterxml.jackson.annotation.JsonPropertyOrder;
 
 @JsonInclude(JsonInclude.Include.NON_NULL)
 @JsonPropertyOrder({
	 "id","data.employee_name",
         "data.employee_salary",
         "data.employee_age",
        
 })

public class Employee {
		@JsonProperty("data.id")
	    private String id;
	 	@JsonProperty("data.employee_salary")
	    private String employee_salary;
	    @JsonProperty("data.employee_name")
	    private String employee_name;
	    @JsonProperty("data.employee_age")
	    private String employee_age;
	    
	    @JsonIgnore
	    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	    
	    @JsonProperty("id")
	    public String getid() {
	        return id;
	    }
	    
	    @JsonProperty("employee_name")
	    public void setname(String employee_name) {
	        this.employee_name = employee_name;
	    }

	    @JsonProperty("employee_age")
	    public String getAge() {
	        return employee_age;
	    }

	    @JsonProperty("employee_age")
	    public void setAge(String employee_age) {
	        this.employee_age = employee_age;
	    }

	    @JsonProperty("employee_salary")
	    public String getsalary() {
	        return employee_salary;
	    }

	    @JsonProperty("employee_salary")
	    public void setsalary(String employee_salary) {
	        this.employee_salary = employee_salary;
	    }

	    @JsonAnyGetter
	    public Map<String, Object> getAdditionalProperties() {
	        return this.additionalProperties;
	    }

	    @JsonAnySetter
	    public void setAdditionalProperty(String name, Object value) {
	        this.additionalProperties.put(name, value);
	    }

}
