package telran.b7a.account.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class UserDto {
String login;
String firstName;
String lastName;
List<String>roles;
}
