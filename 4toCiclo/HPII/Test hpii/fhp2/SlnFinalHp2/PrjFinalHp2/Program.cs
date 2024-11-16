using Microsoft.EntityFrameworkCore;
using PrjFinalHp2.Models;

var builder = WebApplication.CreateBuilder(args);

var cadena = builder.Configuration.GetConnectionString("cn1");

builder.Services.AddDbContext<HpiifinalBibliotecaContext>(x => x.UseSqlServer(cadena));


// Add services to the container.

builder.Services.AddControllers();
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

var app = builder.Build();

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseAuthorization();

app.MapControllers();

app.Run();
