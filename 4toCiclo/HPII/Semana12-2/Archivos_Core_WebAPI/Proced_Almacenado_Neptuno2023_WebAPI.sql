use Neptuno2023
go

create or alter procedure pa_pedidos_cliente_anio
@IdCliente char(5)='',
@Anio int=0
as
	select p.IdPedido,
	       FORMAT(p.FechaPedido, 'dd/MM/yyyy') as FechaPedido,
		   p.IdEmpleado,
		   e.Apellidos,
		   COUNT(dp.IdProducto) as Cant_Prod,
		   SUM(dp.PrecioUnidad * dp.Cantidad) as Importe
	from Pedidos p inner join Detalles_Pedidos dp
		on p.IdPedido = dp.IdPedido
			inner join Empleados e
				on p.IdEmpleado = e.IdEmpleado
	where p.IdCliente = @IdCliente and
		YEAR(p.FechaPedido) = @Anio
	group by p.IdPedido,
	       FORMAT(p.FechaPedido, 'dd/MM/yyyy'), p.IdEmpleado, e.Apellidos
go

exec pa_pedidos_cliente_anio 'BERGS', 2022
go

/*
-- Probando
select * from Detalles_Pedidos where IdPedido in (10778, 10837, 10857, 10866, 10875, 10924)
go
*/
