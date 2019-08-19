package es.eoi.jdbc.entity;

public class Alumno {

		private String DNI;
		private String NOMBRE;
		private String APELLIDOS;
		private int EDAD;
		
		public Alumno(String dni, String nombre, String apellidos, int edad) {
			this.DNI = dni;
			this.NOMBRE = nombre;
			this.APELLIDOS = apellidos;
			this.EDAD = edad;
		}

		public String getDNI() {
			return DNI;
		}

		public void setDNI(String dNI) {
			DNI = dNI;
		}

		public String getNOMBRE() {
			return NOMBRE;
		}

		public void setNOMBRE(String nOMBRE) {
			NOMBRE = nOMBRE;
		}

		public String getAPELLIDOS() {
			return APELLIDOS;
		}

		public void setAPELLIDOS(String aPELLIDOS) {
			APELLIDOS = aPELLIDOS;
		}

		public int getEDAD() {
			return EDAD;
		}

		public void setEDAD(int eDAD) {
			EDAD = eDAD;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Alumno [DNI=");
			builder.append(DNI);
			builder.append(", NOMBRE=");
			builder.append(NOMBRE);
			builder.append(", APELLIDOS=");
			builder.append(APELLIDOS);
			builder.append(", EDAD=");
			builder.append(EDAD);
			builder.append("]");
			return builder.toString();
		}
		
		
}
