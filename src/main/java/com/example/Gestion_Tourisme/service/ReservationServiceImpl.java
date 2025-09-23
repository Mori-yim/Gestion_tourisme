package com.example.Gestion_Tourisme.service;

import com.example.Gestion_Tourisme.dto.reservationDto.ReservationRequestDTO;
import com.example.Gestion_Tourisme.dto.reservationDto.ReservationResponseDTO;
import com.example.Gestion_Tourisme.dto.serviceDto.ServiceRequestDTO;
import com.example.Gestion_Tourisme.dto.serviceDto.ServiceResponseDTO;
import com.example.Gestion_Tourisme.entity.*;
import com.example.Gestion_Tourisme.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService{
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private PaiementRepository paiementRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private AgentRepository agentRepository;
    @Autowired
    private SiteTouristiqueRepository siteTouristiqueRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public ReservationResponseDTO create(ReservationRequestDTO reservation) {
//        Reservation reservation1 = modelMapper.map(reservation, Reservation.class);
//        Reservation saveReservation = reservationRepository.save(reservation1);
//        return modelMapper.map(saveReservation,ReservationResponseDTO.class);
        Client client = clientRepository.findById(reservation.getClientId())
                .orElseThrow(() -> new RuntimeException("Client introuvable"));
        com.example.Gestion_Tourisme.entity.Service service = serviceRepository.findById(reservation.getServiceId())
                .orElseThrow(() -> new RuntimeException("Service introuvable"));

        Reservation reservation1 = modelMapper.map(reservation,Reservation.class);
        reservation1.setClient(client);
        reservation1.setService(service);
        reservation1.setStatut("EN_ATTENTE");

        Reservation saved = reservationRepository.save(reservation1);
        return modelMapper.map(saved, ReservationResponseDTO.class);
    }

    @Transactional
    public ReservationResponseDTO createReservation(ReservationRequestDTO reservationRequestDTO) {

        // Création d'une nouvelle entité Service
        Reservation reservation = new Reservation();
        reservation.setNom(reservationRequestDTO.getNom());
        reservation.setDateReservation(reservationRequestDTO.getDateReservation());
        reservation.setStatut(reservationRequestDTO.getStatut());
        reservation.setDateDebut(reservationRequestDTO.getDateDebut());
        reservation.setDateFin(reservationRequestDTO.getDateFin());


        // Récupérer l'Agent par son id
        Client client = clientRepository.findById(reservationRequestDTO.getClientId())
                .orElseThrow(() -> new RuntimeException("Client non trouvé avec id : " + reservationRequestDTO.getClientId()));
        reservation.setClient(client);

        // Récupérer le Site par son id
        SiteTouristique site = siteTouristiqueRepository.findById(reservationRequestDTO.getSiteId())
                .orElseThrow(() -> new RuntimeException("Site non trouvé avec id : " + reservationRequestDTO.getSiteId()));
        reservation.setSite(site);
        //Recuperer le service par son id
        com.example.Gestion_Tourisme.entity.Service service = serviceRepository.findById(reservationRequestDTO.getServiceId())
                .orElseThrow(()->new RuntimeException("Service non trouve avec id: "+reservationRequestDTO.getServiceId()));
         reservation.setService(service);
        // Pas besoin de setter l'id → généré automatiquement par la DB
        Reservation reservation1=reservationRepository.save(reservation);
        return modelMapper.map(reservation1,ReservationResponseDTO.class);
    }


    // Lire toutes les réservations d’un client
    public List<ReservationResponseDTO> getReservationsByClient(Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client introuvable"));

        return reservationRepository.findByClient(client)
                .stream()
                .map(r -> modelMapper.map(r, ReservationResponseDTO.class))
                .collect(Collectors.toList());
    }

    // Modifier le statut d’une réservation
    @Transactional
    public ReservationResponseDTO updateReservation(Long reservationId, String statut) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new RuntimeException("Réservation introuvable"));
        reservation.setStatut(statut);
        Reservation updated = reservationRepository.save(reservation);
        return modelMapper.map(updated, ReservationResponseDTO.class);
    }
    //Obtenir une reservation par son id
    @Override
    public ReservationResponseDTO getById(Long id) {
        Reservation reservation= reservationRepository.findById(id).get();
        return modelMapper.map(reservation,ReservationResponseDTO.class);
    }

    //lister toutes les reservations
    @Override
    public List<ReservationResponseDTO> getAll() {
        //List<Reservation> reservations= reservationRepository.findAll();
        return reservationRepository.findAll().stream()
                .map(reservation -> modelMapper.map(reservation, ReservationResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ReservationResponseDTO updateById(Long id, ReservationRequestDTO reservationRequestDTO) {
        ReservationResponseDTO reservation= getById(id);
        Reservation reservation1 =modelMapper.map(reservation, Reservation.class);
        reservation1.setNom(reservationRequestDTO.getNom());
        reservation1.setDateDebut(reservationRequestDTO.getDateDebut());
        reservation1.setDateFin(reservationRequestDTO.getDateFin());
        Reservation updateReservation = reservationRepository.save(reservation1);

        return modelMapper.map(updateReservation,ReservationResponseDTO.class);
    }

    @Override
    public void delete(Long id) {
        reservationRepository.deleteById(id);

    }

    @Override
    public void assignerPaiementService(Long id_reservation, Long id_paiement) {
        Reservation reservation = reservationRepository.findById(id_reservation).get();
        Paiement paiement = paiementRepository.findById(id_paiement).get();
        if(paiement.getReservation()!=null){
            //si le paiement est deja assignee a une reservation, alors on leve une exception
            throw new RuntimeException("Le paiement a deja une reservation");
        }
        reservation.getPaiements().add(paiement);
        paiement.setReservation(reservation);
        reservationRepository.save(reservation);
    }
    //Lites des reservations d'un client
    public List<ReservationResponseDTO> getHistoriqueReservations(Long clientId) {
        return getReservationsByClient(clientId);
    }

    // 2️⃣ Réservations liées aux services ------------------------

    public List<ReservationResponseDTO> getReservationsForAgent(Long agentId) {
        Agent agent = agentRepository.findById(agentId)
                .orElseThrow(() -> new RuntimeException("Agent introuvable"));

        return serviceRepository.findByAgent(agent).stream()
                .flatMap(service -> reservationRepository.findByService(service).stream())
                .map(r -> modelMapper.map(r, ReservationResponseDTO.class))
                .collect(Collectors.toList());
    }

    // Créer une réservation
    @Transactional
    public ReservationResponseDTO createReservation(Long clientId, Long serviceId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client introuvable"));
        com.example.Gestion_Tourisme.entity.Service service = serviceRepository.findById(serviceId)
                .orElseThrow(() -> new RuntimeException("Service introuvable"));

        Reservation reservation = new Reservation();
        reservation.setClient(client);
        reservation.setService(service);
        reservation.setStatut("EN_ATTENTE");

        Reservation saved = reservationRepository.save(reservation);
        return modelMapper.map(saved, ReservationResponseDTO.class);
    }



}
