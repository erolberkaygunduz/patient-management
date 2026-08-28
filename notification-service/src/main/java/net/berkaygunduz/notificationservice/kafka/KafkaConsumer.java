package net.berkaygunduz.notificationservice.kafka;

import com.google.protobuf.InvalidProtocolBufferException;
import org.slf4j.*;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import patient.event.PatientEvent;

@Service
public class KafkaConsumer {

    private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "patient", groupId = "notification-service")
    public void consumeEvent(byte[] event){
        try {
            PatientEvent patientEvent = PatientEvent.parseFrom(event);
            log.info("Notification service received for sending mail : [PatientId={}, PatientName={}, " +
                            "PatientEmail={}]",
                    patientEvent.getPatientId(),
                    patientEvent.getName(),
                    patientEvent.getEmail());
        }catch (InvalidProtocolBufferException e){
            log.error("Error deserializing event {} ",e.getMessage());
        }

    }
}
