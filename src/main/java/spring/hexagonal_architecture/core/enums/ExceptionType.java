package spring.hexagonal_architecture.core.enums;

public enum ExceptionType {

	INVALID_TICKET{
		@Override
		public String getErrorMessage() {
			// TODO Auto-generated method stub
			return "O ticket encontrado é inválido.";
		}
	},	
 	INVALID_TICKET_TYPE{
		@Override
		public String getErrorMessage() {
			// TODO Auto-generated method stub
			return "Podemos calcular apenas ticket do tipo XPTO.";
		}
	},	
	NOT_EXPIRED_TICKET{
		@Override
		public String getErrorMessage() {
			// TODO Auto-generated method stub
			return "O ticket ainda não expirou.";
		}
	};
	
	public abstract String getErrorMessage(); 
		
	
	
	
}
