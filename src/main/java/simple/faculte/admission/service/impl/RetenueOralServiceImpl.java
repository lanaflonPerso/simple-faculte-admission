/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simple.faculte.admission.service.impl;

import com.anas.Inscription.common.util.NumberUtil;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simple.faculte.admission.bean.RetenueEcrit;
import simple.faculte.admission.dao.RetenueEcritDao;
import simple.faculte.admission.rest.proxy.ConcoursProxy;
import simple.faculte.admission.rest.vo.exchange.EtudiantConcoursVo;
import simple.faculte.admission.service.RetenueEcritService;
import simple.faculte.admission.service.RetenueOralService;

/**
 *
 * @author Anas
 */
@Service
public class RetenueOralServiceImpl implements RetenueOralService {

    @Autowired
    private RetenueEcritService retenueEcritService;
    @Autowired
    private RetenueEcritDao retenueEcritDao;
    @Autowired
    private ConcoursProxy concoursProxy;

    @Override
    public List<RetenueEcrit> findListeRetenueOral(String refConcours) {

        List<RetenueEcrit> listE = retenueEcritService.findRetenusByRefConcours(refConcours);
        if (listE == null || listE.isEmpty()) {
            return null;
        }
        int x = NumberUtil.toInt(concoursProxy.findByReference(refConcours).getNbreplaceConcoursOral());

        for (int i = 0; i < x; i++) {
            if (i < listE.size()) {
                listE.get(i).setPreselectione(true);
                listE.get(i).setRetenueOral(true);
            }

        }
        return listE;
    }

    @Override
    public int saveRetenueOral(List<RetenueEcrit> retenueEcrits) {
        if (retenueEcrits.isEmpty() || retenueEcrits == null) {
            return -1;
        } else {
            for (RetenueEcrit retenueEcrit : retenueEcrits) {
                RetenueEcrit r = retenueEcritService.findByRefCandidat(retenueEcrit.getRefCandidat());
                r.setRetenueOral(true);
                retenueEcritDao.save(r);
            }
            return 1;
        }
    }

    @Override
    public List<RetenueEcrit> listeRetenueInBd(String refConcours) {
        return retenueEcritDao.findByRefConcoursAndRetenueOralOrderByNoteConcoursNoteOralDesc(refConcours, true);
    }

}
