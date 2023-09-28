package com.example.demo.user.service;

import com.example.demo.user.entity.UserEntity;
import com.example.demo.user.exception.UserNotFoundException;
import com.example.demo.user.model.UserDto;
import com.example.demo.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepo;
    public UserService(UserRepository userRepo){
        this.userRepo = userRepo;
    }

    public void create(UserDto user){
        UserEntity userEntity = new UserEntity();
        userEntity.setName(user.getName());
        userEntity.setId(user.getId());
        userEntity.setAge(user.getAge());
       this.userRepo.save(userEntity);
    }

    public List<UserDto> get() {
        List<UserDto> userDtos = new ArrayList<>();

        Iterable<UserEntity> entities = this.userRepo.findAll();
        entities.forEach(userEntity -> {
            UserDto dto = new UserDto();
            dto.setId(userEntity.getId());
            dto.setAge(userEntity.getAge());
            dto.setName(userEntity.getName());
            userDtos.add(dto);
        });
        return userDtos;
    }

    public void delete(int id) {
      this.userRepo.deleteById(id);
    }

    public UserDto get(int id) {
        Optional<UserEntity> entity = this.userRepo.findById(id);
        if(entity.isPresent()) {
            final UserDto user = new UserDto();
            user.setId(entity.get().getId());
            user.setName(entity.get().getName());
            user.setAge(entity.get().getAge());
            return user;
        }
        throw new UserNotFoundException(id) ;
    }

    public void update(int id, UserDto userDto) {
        Optional<UserEntity> entity = this.userRepo.findById(id);
        if (entity.isPresent()) {
            final UserDto user = new UserDto();
            entity.get().setName(userDto.getName());
            entity.get().setAge(userDto.getAge());
            this.userRepo.save(entity.get());
        }
    }
}
