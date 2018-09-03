package booking_site.xws_proj.domain.dto.mappper;

import booking_site.xws_proj.domain.Comment;
import booking_site.xws_proj.domain.dto.response.CommentResponseDTO;

public class CommentMapper {

	public static CommentResponseDTO mapEntityIntoDTO(Comment entity) {
		if (entity == null) {
			return null;
		}
		CommentResponseDTO dto = new CommentResponseDTO();
		dto.setId(entity.getId());
		dto.setAccommodation(AccommodationMapper.mapEntityIntoDTO(entity.getAccommodation()));
		dto.setUser(UserMapper.mapEntityIntoDTO(entity.getUser()));
		dto.setApprovalState(entity.getApprovalState());
		dto.setText(entity.getText());
		dto.setTime(entity.getTime());

		return dto;
	}
}
