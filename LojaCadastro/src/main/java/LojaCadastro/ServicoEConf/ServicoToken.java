package LojaCadastro.ServicoEConf;

import java.sql.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import LojaCadastro.Modelo.Cliente;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;

@Service
public class ServicoToken {
	
	@Value("${forum.jwt.expiration}")
    private String expiration;

    @Value("${forum.jwt.secret}")
    private String secret;

    public String gerarToken(Authentication authentication)
    {
        Cliente logado = (Cliente) authentication.getPrincipal();
        Date hoje = new Date(0);
        Date Date_2 = new Date(hoje.getTime() + Long.parseLong(expiration));
    
    return Jwts.builder()
            .setIssuer("LOJINHA DA ERIKA").
            setSubject(logado.getId().toString())
            .setIssuedAt(hoje)
            .setExpiration(Date_2).
            signWith(SignatureAlgorithm.HS256, secret)
            .compact();
}
    public boolean isValidToken(String token){
        try{
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
        }

public long getId(String token) {
    Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    return Long.parseLong(claims.getSubject());
}
}
