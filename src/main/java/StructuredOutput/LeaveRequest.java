
package StructuredOutput;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

@JsonClassDescription("Leave Details taken from the Employee Email")
public record LeaveRequest(

    @JsonProperty("asking_for_leave")
    @JsonPropertyDescription("Only true if email is talking about leave otherwise false")
    boolean askingForLeave,

    @JsonProperty("employee_name")
    @JsonPropertyDescription("Full name of the employee who wants the leave")
    String employeeName,

    @JsonProperty("leave_type")
    @JsonPropertyDescription("Type of leave requested by the employee")
    LeaveType leaveType,

    @JsonProperty("start_date")
    @JsonPropertyDescription("First day of leave in yyyy-MM-dd format")
    String startDate,

    @JsonProperty("end_date")
    @JsonPropertyDescription("Last day of leave in yyyy-MM-dd format")
    String endDate,

    @JsonProperty("reason")
    @JsonPropertyDescription("Reason for the leave in a few words")
    String reason,

    @JsonProperty("phone_model")
    @JsonPropertyDescription("Phone model mentioned in the email. Return null if not mentioned")
    String phoneModel,

    @JsonProperty("medical_certificate_shared")
    @JsonPropertyDescription("True if the employee has shared a medical certificate, otherwise false")
    boolean medicalCertificateShared

) {
}
