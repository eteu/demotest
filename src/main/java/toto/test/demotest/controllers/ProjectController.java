package toto.test.demotest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import toto.test.demotest.models.Project;
import toto.test.demotest.services.ProjectService;

import java.util.List;

@RestController
@RequestMapping("/projects/")
public class ProjectController {
    private final ProjectService service;

    public ProjectController(ProjectService service) {
        this.service = service;
    }

    @GetMapping("all")
    public List<Project> all() {
        return service.all();
    }

    @GetMapping("{id}")
    public Project byId(@PathVariable Long id) {
        return service.byId(id);
    }


    @GetMapping("saveOrUpdate/{id}/{name}")
    public Project saveOrUpdate(@PathVariable long id, @PathVariable String name) {
        return service.saveOrUpdate(new Project(id,name));
    }

    @GetMapping("delete/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}
