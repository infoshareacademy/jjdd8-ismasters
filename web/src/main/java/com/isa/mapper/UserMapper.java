package com.isa.mapper;

import com.isa.domain.dto.UserDto;
import com.isa.domain.entity.User;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;
import java.util.stream.Collectors;

@Stateless
public class UserMapper {

  @EJB
  EventMapper eventMapper;

  @Transactional
  public UserDto mapEntityToDto(User user) {
    UserDto userDto = new UserDto();
    userDto.setId(user.getId());
    userDto.setName(user.getName());
    userDto.setEmail(user.getEmail());
    userDto.setGoogleId(user.getGoogleId());
    userDto.setEventDtoList(user.getFavoriteEvents().stream()
        .map(event -> eventMapper.mapEntityToDto(event))
        .collect(Collectors.toList()));
    userDto.setUserType(user.getUserType());
    return userDto;
  }

  @Transactional
  public User mapDtoToEntity(UserDto userDto) {
    User user = new User();
    user.setName(userDto.getName());
    user.setEmail(userDto.getEmail());
    user.setUserType(userDto.getUserType());
    user.setGoogleId(userDto.getGoogleId());
    return user;
  }
}
