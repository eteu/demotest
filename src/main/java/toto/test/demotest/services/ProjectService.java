package toto.test.demotest.services;

import org.springframework.stereotype.Service;
import toto.test.demotest.models.Project;

import java.util.List;

@Service
public class ProjectService implements IProjectService {
    @Override
    public List<Project> all() {
        return null;
    }

    @Override
    public Project byId(Long id) {
        return null;
    }

    @Override
    public Project saveOrUpdate(Project projet) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
