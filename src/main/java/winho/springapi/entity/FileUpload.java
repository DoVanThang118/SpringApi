package winho.springapi.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "files")
public class FileUpload {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String type;

    @Lob
    @Column(name = "image", length = 5 * 1024 * 1024)
    private byte[] image;
}
