package demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.SprintBootApplication1;
import com.example.demo.dao.RoleRepository;
import com.example.demo.pojo.Role;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SprintBootApplication1.class)
public class RoleRepositoryTest {

	@Autowired
	private RoleRepository roleRepository;

	@Test
	public void testInsert() {
		List<Role> roleList = new ArrayList<Role>();
		Role role = new Role();
		role.setName("xiaowang1");
		role.setId(2);
		role.setDescr("xiialwais2");
		Role role1 = new Role();
		role1.setName("xiaowang3");
		role1.setId(3);
		role1.setDescr("xiialwais4");
		Role role2 = new Role();
		role2.setName("xiaowang5");
		role2.setId(4);
		role2.setDescr("xiialwais6");
		roleList.add(role1);
		roleList.add(role);
		roleList.add(role2);
		List<Role> result = this.roleRepository.saveAll(roleList);
		for (Role role3 : result) {
			System.out.println(role3.getName());
		}
	}

	@Test
	public void testSelect() {
		List<Role> roleList = this.roleRepository.findAll();
		for (Role role : roleList) {
			System.out.println(role.getName());
		}
	}

	@Test
	public void testUpdate() {
		Role role = new Role();
		role.setId(1);
		role.setDescr("第一");
		role.setName("小王");
		boolean flag = this.roleRepository.existsById(role.getId());
		Role roel1 = this.roleRepository.save(role);
		if (flag) {
			System.out.println("更新成功");
		} else {
			System.out.println("更新失败没有本角色");
		}
		System.out.println(roel1.getName() + roel1.getId());
	}

	@Test
	public void testDelete() {
		Integer roleId = 5;
		if (this.roleRepository.existsById(roleId)) {
			System.out.println("删除成功");
			this.roleRepository.deleteById(roleId);
		} else {
			System.out.println("删除失败，没有本角色");
		}
	}

}
