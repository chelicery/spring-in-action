delete from TacoOrderTacos;
delete from TacoIngredients;
delete from Taco;
delete from TacoOrder;
delete from Ingredient;

insert into Ingredient (id, name, type)
    values ('FLTO', 'pszenna', 'WRAP');
insert into Ingredient (id, name, type)
    values ('COTO', 'kukurydziana', 'WRAP');
insert into Ingredient (id, name, type)
    values ('GRBF', 'mielona wołowina', 'PROTEIN');
insert into Ingredient (id, name, type)
    values ('CARN', 'kawałki mięsa', 'PROTEIN');
insert into Ingredient (id, name, type)
    values ('TMTO', 'pomidory pokrojone w kostkę', 'VEGGIE');
insert into Ingredient (id, name, type)
    values ('LETC', 'sałata', 'VEGGIE');
insert into Ingredient (id, name, type)
    values ('CHED', 'cheddar', 'CHEESE');
insert into Ingredient (id, name, type)
    values ('JACK', 'Monterey Jack', 'CHEESE');
insert into Ingredient (id, name, type)
    values ('SLSA', 'pikantny sos pomidorowy', 'SAUCE');
insert into Ingredient (id, name, type)
    values ('SRCR', 'śmietana', 'SAUCE');