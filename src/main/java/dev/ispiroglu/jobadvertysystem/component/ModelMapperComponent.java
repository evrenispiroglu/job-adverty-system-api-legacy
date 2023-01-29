package dev.ispiroglu.jobadvertysystem.component;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperComponent {

  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }

}
