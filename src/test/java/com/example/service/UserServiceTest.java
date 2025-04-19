//package com.example.service;
//
//import com.example.spring_boot_rest_api.entities.User;
//import com.example.spring_boot_rest_api.repositories.UserRepository;
//import com.example.spring_boot_rest_api.services.UserService;
//import com.example.spring_boot_rest_api.services.impl.UserServiceImpl;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//class UserServiceTest {
//
//    @Mock
//    private UserRepository userRepository;
//
//    @InjectMocks
//    private UserServiceImpl userServiceImpl;
//
//    private User testUser;
//
//    @BeforeEach
//    void setUp(){
//        testUser = new User(1L,"Karim","karim@gmail.com",54);
//    }
//
//    @Test
//    void testCreateUser() {
//        when(userRepository.save(testUser)).thenReturn(testUser);
//
//        User createdUser = userServiceImpl.saveUser(testUser);
//
//        assertNotNull(createdUser);
//        assertEquals("Karim", createdUser.getName());
//        verify(userRepository, times(1)).save(testUser);
//    }
//
//    @Test
//    void testGetUserById() {
//        when(userRepository.findById(1L)).thenReturn(Optional.of(testUser));
//
//        User foundUser = userServiceImpl.getUserById(1L);
//
//        assertNotNull(foundUser);
//        assertEquals(1L, foundUser.getId());
//        verify(userRepository, times(1)).findById(1L);
//    }
//
//    @Test
//    void testGetAllUsers() {
//        List<User> users = Arrays.asList(testUser, new User("Amil", "amil@gmail.com", 43));
//        when(userRepository.findAll()).thenReturn(users);
//
//        List<User> allUsers = userServiceImpl.getAllUsers();
//
//        assertEquals(users, allUsers);
//        verify(userRepository, times(1)).findAll();
//    }
//
//    @Test
//    void testUpdateUser() {
//        when(userRepository.findById(1L)).thenReturn(Optional.of(testUser));
//        when(userRepository.save(any(User.class))).thenReturn(testUser);
//
//        User updateUser = new User(1L,"Rasul","rasul@gmail.com",12);
//        User result = userServiceImpl.updateUser(updateUser, 1L);
//
//        assertNotNull(result);
//        assertEquals("Rasul", result.getName());
//        verify(userRepository, times(1)).findById(1L);
//        verify(userRepository, times(1)).save(any(User.class));
//    }
//
//    @Test
//    void testDeleteUser() {
////        when(userRepository.findById(1L)).thenReturn(Optional.of(testUser));
//        doNothing().when(userRepository).deleteById(1L);
//
//        userServiceImpl.deleteUserById(1L);
//
//        verify(userRepository, times(1)).deleteById(1L);
//    }
//
//}
