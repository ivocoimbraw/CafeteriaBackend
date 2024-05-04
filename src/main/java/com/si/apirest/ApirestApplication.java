package com.si.apirest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.si.apirest.model.entity.PermissionEntity;
import com.si.apirest.model.entity.Person;
import com.si.apirest.model.entity.RoleEntity;
import com.si.apirest.model.entity.RolePermissionEntity;
import com.si.apirest.model.enums.Permission;
import com.si.apirest.model.enums.Role;
import com.si.apirest.model.repository.PermissionRepository;
import com.si.apirest.model.repository.PersonRepository;
import com.si.apirest.model.repository.RolPermissionRepository;
import com.si.apirest.model.repository.RolRepository;

@SpringBootApplication
public class ApirestApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ApirestApplication.class, args);

		//Tomar todos los beans del contexto de spring
		PermissionRepository permissionRepository = context.getBean(PermissionRepository.class);
		RolRepository rolRepository = context.getBean(RolRepository.class); 
		RolPermissionRepository rolPermissionRepository = context.getBean(RolPermissionRepository.class);
		PersonRepository personRepository = context.getBean(PersonRepository.class);
		PasswordEncoder passwordEncoder = context.getBean(PasswordEncoder.class);
		ModelMapper modelMapper = context.getBean(ModelMapper.class);

		//si no existen permisos y roles los crea
		if (permissionRepository.count()==0 && rolRepository.count() == 0){
			List<PermissionEntity> permissionEntities = new ArrayList<PermissionEntity>();
			List<PermissionEntity> permissionEntitiesSaved = new ArrayList<PermissionEntity>();
			//Guarda todos los permisos del enum Permission
			for (String nombre : Permission.getAllPermissionNames()) {
				permissionEntities.add(PermissionEntity.builder().nombre(nombre).build());
			}
			permissionEntitiesSaved = permissionRepository.saveAllAndFlush(permissionEntities);
			
			//Se guarda el Rol ADMIN
			RoleEntity rolSaved = rolRepository.save(RoleEntity.builder().name(Role.ADMIN.toString()).build());
			//Se guarda el Rol USER
			RoleEntity rolUser = rolRepository.save(RoleEntity.builder().name(Role.USER.toString()).build());
			rolPermissionRepository.save(RolePermissionEntity.builder()
				.permiso(permissionEntitiesSaved.get(permissionEntities.size()-1))
				.rol(rolUser).build());
			
			
			//se asignan todos los permisos existentes a Rol ADMIN
			for (PermissionEntity permissionEntity : permissionEntitiesSaved) {
				rolPermissionRepository.save(RolePermissionEntity.builder()
				.permiso(permissionEntity)
				.rol(rolSaved).build());
			}
			//Crea el usuario Admin
			createUserAdmin(personRepository, rolSaved,passwordEncoder, modelMapper);
		}

	}

	private static void createUserAdmin(PersonRepository personRepository,RoleEntity rol, PasswordEncoder passwordEncoder,
	ModelMapper modelMapper
	) {
		Optional<Person> optionalUser = personRepository.findByUsuario(Role.ADMIN.toString());
        Person user= Person.builder()
		.usuario(Role.ADMIN.toString())
		.contraseña(passwordEncoder.encode("65873154"))
		.nombre("ADMIN")
		.email("wolfcoimbraivo@gmail.com")
		.role(rol)
		.enabled(true)
		.build();

		optionalUser.ifPresent(userAdmin-> {
			modelMapper.map(userAdmin, user);
		});
		
		personRepository.save(user);
	}

}
