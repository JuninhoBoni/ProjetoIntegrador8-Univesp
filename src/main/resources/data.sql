INSERT INTO public.tb_role (id, profile)
    VALUES(0, 'MUNICIPE')
    ON CONFLICT (id) DO UPDATE
    SET profile = excluded.profile;
INSERT INTO public.tb_role (id, profile)
    VALUES(1, 'ADMIN')
    ON CONFLICT (id) DO UPDATE
    SET profile = excluded.profile;
INSERT INTO public.tb_role (id, profile)
    VALUES(2, 'AGENTE')
    ON CONFLICT (id) DO UPDATE
    SET profile = excluded.profile;