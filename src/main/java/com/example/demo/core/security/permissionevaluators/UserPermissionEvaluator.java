package com.example.demo.core.security.permissionevaluators;

import com.example.demo.domain.user.User;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Permission-Evaluator für User-spezifische Berechtigungsprüfungen.
 */
@Component
@NoArgsConstructor
public class UserPermissionEvaluator {

  /** Beispiel-Evaluator für @PreAuthorize */
  public boolean exampleEvaluator(User principal, UUID id) {
    //your code here
    return true;
  }

}
