<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="2.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
	<xsl:output method="text" omit-xml-declaration="yes"
		indent="no" encoding="UTF-8" />
	<xsl:template match="/"><xsl:value-of select="/root/consultarControversiasRequest/comercio/ruc" />/<xsl:value-of select="/root/consultarControversiasRequest/comercio/id" />/<xsl:value-of select="/root/consultarControversiasRequest/controversia/fechaInicio" />/<xsl:value-of select="/root/consultarControversiasRequest/controversia/fechaFin" />/<xsl:value-of select="/root/consultarControversiasRequest/controversia/estado" />/<xsl:value-of select="/root/consultarControversiasRequest/controversia/numeroAutorizacion" />/<xsl:value-of select="/root/consultarControversiasRequest/controversia/tipo" />/<xsl:value-of select="/root/consultarControversiasRequest/numeroPagina" />/<xsl:value-of select="/root/consultarControversiasRequest/numeroRegistroPagina" />
	</xsl:template>
</xsl:stylesheet>