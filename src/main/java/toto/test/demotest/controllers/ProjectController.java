package toto.test.demotest.controllers;

import org.springframework.web.bind.annotation.RestController;
import toto.test.demotest.models.Project;
import toto.test.demotest.services.ProjectService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
public class ProjectController {
    final private ProjectService service;

    public ProjectController(ProjectService service) {
        this.service = service;
    }

    public List<Project> all() {
        return service.all();
    }

    public Project byId(Long id) {
        return service.byId(id);
    }

    public Project saveOrUpdate(Project projet) {
        return service.saveOrUpdate(projet);
    }

    public void deleteById(Long id) {
        service.deleteById(id);
    }
}
