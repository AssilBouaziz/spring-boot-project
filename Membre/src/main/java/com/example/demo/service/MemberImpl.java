package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.beans.PublicationBean;
import com.example.demo.dao.EnseignantChercheurRepository;
import com.example.demo.dao.EtudiantRepository;
import com.example.demo.dao.MemberRepository;
import com.example.demo.dao.MembrePubRepository;
import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Membre;
import com.example.demo.entities.Membre_Pub_Id;
import com.example.demo.entities.Membre_Publication;
import com.example.demo.proxies.PublicationProxyService;

@Service
public class MemberImpl implements IMemberService {
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	EtudiantRepository etudiantRepository;
	@Autowired
	EnseignantChercheurRepository enseignantChercheurRepository;
	@Autowired
	MembrePubRepository membrepubrepository;
	@Autowired
	PublicationProxyService proxy;

	public Membre addMember(Membre m) {
		memberRepository.save(m);
		return m;
	}

	public void deleteMember(Long id) {
		memberRepository.deleteById(id);
	}

	public Membre updateMember(Membre m) {
		return memberRepository.saveAndFlush(m);
	}

	public Membre findMember(Long id) {
		Membre m = (Membre) memberRepository.findById(id).get();
		return m;
	}

	public List<Membre> findAll() {
		return memberRepository.findAll();
	}

	public Membre findByCin(String cin) {
		return memberRepository.findByCin(cin);
	}

	public Membre findByEmail(String email) {
		return memberRepository.findByEmail(email);
	}

	public List<Membre> findByNom(String nom) {
		return memberRepository.findByNom(nom);
	}

	public List<Etudiant> findByDiplome(String diplome) {
		return etudiantRepository.findByDiplome(diplome);
	}

	/*
	 * public List<Etudiant> findEtudiantByEncadrant(EnseignantChercheur
	 * enseignantChercheur) { return
	 * etudiantRepository.findEtudiantByEncadrant(enseignantChercheur); }
	 */

	public List<EnseignantChercheur> findByGrade(String grade) {
		return enseignantChercheurRepository.findByGrade(grade);
	}

	public List<EnseignantChercheur> findByEtablissement(String etablissement) {
		return enseignantChercheurRepository.findByEtablissement(etablissement);
	}

	@Override
	public void affecterauteurTopublication(Long idauteur, Long idpub) {
		Membre mbr = (Membre) memberRepository.findById(idauteur).get();
		Membre_Publication mbs = new Membre_Publication();
		mbs.setAuteur(mbr);
		mbs.setId(new Membre_Pub_Id(idpub, idauteur));
		membrepubrepository.save(mbs);
	}

	@Override
	public List<PublicationBean> findPublicationparauteur(Long idauteur) {
		List<PublicationBean> pubs = new ArrayList<PublicationBean>();
		Membre auteur = memberRepository.findById(idauteur).get();
		List<Membre_Publication> idpubs = membrepubrepository.findByAuteur(auteur);
		idpubs.forEach(s -> {
			System.out.println(s);
			pubs.add(proxy.findPublicationById(s.getId().getPublication_id()));
		});
		return pubs;
	}
	/*
	 * @Override
	 * 
	 * public void affecterEtudiantToEnseignant(long id_ens, long id_etu) { Etudiant
	 * e = (Etudiant) etudiantRepository.findById(id_etu).get(); EnseignantChercheur
	 * ec = (EnseignantChercheur)
	 * enseignantChercheurRepository.findById(id_ens).get();
	 * 
	 * }
	 */

}