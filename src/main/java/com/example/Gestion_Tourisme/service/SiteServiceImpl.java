package com.example.Gestion_Tourisme.service;

import com.example.Gestion_Tourisme.dto.siteTouristiqueDto.SiteTouristiqueRequestDTO;
import com.example.Gestion_Tourisme.dto.siteTouristiqueDto.SiteTouristiqueResponseDTO;
import com.example.Gestion_Tourisme.entity.SiteTouristique;
import com.example.Gestion_Tourisme.repository.SiteTouristiqueRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SiteServiceImpl implements SiteService{
    @Autowired
    private SiteTouristiqueRepository siteTouristiqueRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public SiteTouristiqueResponseDTO create(SiteTouristiqueRequestDTO siteTouristiqueRequestDTO) {
        SiteTouristique site = modelMapper.map(siteTouristiqueRequestDTO,SiteTouristique.class);
        SiteTouristique saveSite = siteTouristiqueRepository.save(site);
        return modelMapper.map(saveSite,SiteTouristiqueResponseDTO.class);
    }

    @Override
    public SiteTouristiqueResponseDTO getById(Long id) {
        SiteTouristique site = siteTouristiqueRepository.findById(id).get();
        return modelMapper.map(site,SiteTouristiqueResponseDTO.class);
    }

    @Override
    public List<SiteTouristiqueResponseDTO> getAll() {
        //List<SiteTouristique> sites = siteTouristiqueRepository.findAll();
        return siteTouristiqueRepository.findAll().stream()
                .map(siteTouristique -> modelMapper.map(siteTouristique, SiteTouristiqueResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public SiteTouristiqueResponseDTO UpdateById(Long id, SiteTouristiqueRequestDTO site) {
        SiteTouristiqueResponseDTO siteTouristiqueResponseDTO = getById(id);
        SiteTouristique existSite = modelMapper.map(siteTouristiqueResponseDTO,SiteTouristique.class);
        existSite.setNom(site.getNom());
        existSite.setDescription(site.getDescription());
        existSite.setLocalisation(site.getLocalisation());
        existSite.setImage(site.getImage());
        existSite.setClimat(site.getClimat());
        SiteTouristique saveSite = siteTouristiqueRepository.save(existSite);
        return modelMapper.map(saveSite,SiteTouristiqueResponseDTO.class);
    }

    @Override
    public void delete(Long id) {
        siteTouristiqueRepository.deleteById(id);
    }

    // 3️ Recherche de sites ------------------------

    public List<SiteTouristiqueResponseDTO> searchSites(SiteTouristiqueRequestDTO siteRequest) {
        List<SiteTouristique> sites;

        if (siteRequest.getNom() != null && !siteRequest.getNom().isEmpty()) {
            sites = siteTouristiqueRepository.findByNomContainingIgnoreCase(siteRequest.getNom());
        } else if (siteRequest.getLocalisation() != null && !siteRequest.getLocalisation().isEmpty()) {
            sites = siteTouristiqueRepository.findByLocalisationContainingIgnoreCase(siteRequest.getLocalisation());
        } else {
            sites = siteTouristiqueRepository.findAll();
        }

        return sites.stream()
                .map(site -> modelMapper.map(site, SiteTouristiqueResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public SiteTouristiqueResponseDTO chearchByNom(String nom) {
        return (SiteTouristiqueResponseDTO) siteTouristiqueRepository.findByNomContainingIgnoreCase(nom);
    }

    @Override
    public List<SiteTouristique> chearchByLocalisation(String localisation) {
        return siteTouristiqueRepository.findByLocalisationContainingIgnoreCase(localisation);
    }
}
