package ambiefac.back.domain.dtos.topic;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


public class RegisterTopicDto {
	
	@NotBlank(message = "Name is required")
    @NotNull(message = "error")
    @Column(unique = true)
    private String name;
    @NotNull()
    @NotBlank(message = "Time is required")
    private String time;

    @NotBlank(message = "Description is required")
    @NotNull
    private String description;

    private String linkImage;

    public RegisterTopicDto(){}
    
    

    public RegisterTopicDto(@NotNull @NotBlank String name, @NotNull @NotBlank String time,
			@NotBlank @NotNull String description, @NotBlank @NotNull String linkImage) {
		super();
		this.name = name;
		this.time = time;
		this.description = description;
		this.linkImage = linkImage;
	}



	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLinkImage() {
        return linkImage;
    }

    public void setLinkImage(String linkImage) {
        this.linkImage = linkImage;
    }
}
