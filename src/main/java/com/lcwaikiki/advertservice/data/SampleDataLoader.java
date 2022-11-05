package com.lcwaikiki.advertservice.data;

import com.github.javafaker.Faker;
import com.lcwaikiki.advertservice.exception.UserNotFoundException;
import com.lcwaikiki.advertservice.repository.AdvertRepository;
import com.lcwaikiki.advertservice.repository.UserRepository;
import com.lcwaikiki.advertservice.service.OperationHandlerService;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SampleDataLoader implements CommandLineRunner {

  private final Logger logger = LoggerFactory.getLogger(SampleDataLoader.class);
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final OperationHandlerService operationHandlerService;
  private final AdvertRepository advertRepository;
  private final Faker faker;

  public SampleDataLoader(UserRepository userRepository, PasswordEncoder passwordEncoder,
      OperationHandlerService operationHandlerService, AdvertRepository advertRepository,
      Faker faker) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
    this.operationHandlerService = operationHandlerService;
    this.advertRepository = advertRepository;
    this.faker = faker;
  }

  private boolean activate(Date startDate, Date endDate) {
    Date today = new Date();
    return startDate.getTime() <= today.getTime() && today.getTime() < endDate.getTime();
  }

  public void run(String... args) throws UserNotFoundException {
    logger.info("Updating Adverts");
//
//    for (int i = 1; i < 32; i++) {
//      operationHandlerService.createAdvert(
//          new CreateAdvertRequest(
//              faker.job().title(), faker.company().industry(), new Date(), new Date(),
//              faker.company().profession(), 10, "Remote", "Remote", 0,
//              faker.company().buzzword(), faker.company().name(), faker.job().field()
//          ), (long) ((i % 2) + 1)
//      );
//    }

//    List<Advert> list = IntStream.rangeClosed(1, 100)
//        .mapToObj(i -> new Advert(
//            faker.company().name(),
//            faker.company().buzzword(),
//            faker.date().future(10, 2, TimeUnit.DAYS),
//            faker.date().future(60, 10, TimeUnit.DAYS),
//            faker.job().position(), 100, faker.address().cityName(), faker.address().state(),
//            10,
//            faker.job().title(), true, null, faker.company().name(), faker.job().field()
//        ))
//        .toList();

//    advertRepository.saveAll(list);
//    List<User> userList = userRepository.findAll();
//    userList.forEach(
//        user -> user.setPassword(passwordEncoder.encode(user.getPassword()))
//    );
//    userRepository.saveAll(userList);

//    List<Advert> advertList = advertRepository.findAll();
//    for (Advert advert : advertList) {
//      if (advert.getApplications() != null)
//        if (Objects.equals(advert.getApplications().size(), advert.getCapacity()))
//          advert.setActive(
//              activate(advert.getStartDate(), advert.getEndDate())
//          );
//
//    }
  }

}
