USE [master]
GO

CREATE LOGIN [soc_user] WITH PASSWORD=N'123456', DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[Português (Brasil)], CHECK_EXPIRATION=OFF, CHECK_POLICY=OFF
GO

USE [SOC]
GO

CREATE USER [soc_user] FOR LOGIN [soc_user] WITH DEFAULT_SCHEMA=[dbo]
GO

CREATE TABLE [dbo].[exame](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[nome_paciente] [varchar](50) NOT NULL,
	[nome_exame] [varchar](50) NOT NULL,
	[data_exame] [date] NOT NULL,
	[resultado] [varchar](max) NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO


