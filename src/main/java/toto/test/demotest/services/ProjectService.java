package toto.test.demotest.services;

import org.springframework.stereotype.Service;
import toto.test.demotest.models.Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService implements IProjectService {
    List<Project> listeProject = new ArrayList<>();
    @Override
    public List<Project> all() {
        return listeProject;
    }

    @Override
    public Project byId(Long id) {

        /*Optional<Project> result = listeProject.stream().filter(project -> project.getId() == id).findFirst();
        return result.isPresent() ? result.get() : new Project();*/

        // return listeProject.stream().filter(project -> project.getId() == id).findFirst().orElse(getNewProject());

        //return listeProject.stream().filter(project -> project.getId() == id).findFirst().orElseGet(Project::new);

        return listeProject.stream().filter(project -> project.getId() == id ).findFirst().orElseGet(() -> new Project());
    }

    @Override
    public Project saveOrUpdate(Project projet) {
        if (projet.getId() == 0) {
            projet.setId(3L);
            listeProject.add(projet);
        } else {
            final Project finalProjet = projet;
            Optional<Project> result = listeProject.stream()
                    .filter(project -> project.getId() == finalProjet.getId())
                    .findFirst();
            if (result.isPresent()) {
                result.get().setName(projet.getName());
            } else {
                projet.setId(3L);
                listeProject.add(projet);
            }
        }
        return projet;
    }

    private Project getNewProject() {
        return new Project();
    }

    @Override
    public void deleteById(Long id) {
    }

    @Override
    public void setListeProject(ArrayList<Project> projects) {
        listeProject = projects;
    }
}
