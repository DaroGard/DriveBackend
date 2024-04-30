package unah.edu.hn.bases1.proyecto.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.edu.hn.bases1.proyecto.Entities.Plan;
import unah.edu.hn.bases1.proyecto.repository.PlanRepository;
import unah.edu.hn.bases1.proyecto.services.PlanService;

@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanRepository planRepository;

    @Override
    public Plan crearPlan(Plan plan) {
        return planRepository.save(plan);
    }

}
