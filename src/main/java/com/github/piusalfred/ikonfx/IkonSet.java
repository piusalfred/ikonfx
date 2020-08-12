package com.github.piusalfred.ikonfx;

import org.kordamp.ikonli.Ikon;
import org.kordamp.ikonli.dashicons.Dashicons;
import org.kordamp.ikonli.devicons.Devicons;
import org.kordamp.ikonli.elusive.Elusive;
import org.kordamp.ikonli.entypo.Entypo;
import org.kordamp.ikonli.feather.Feather;
import org.kordamp.ikonli.fontawesome.FontAwesome;
import org.kordamp.ikonli.fontawesome5.FontAwesomeBrands;
import org.kordamp.ikonli.fontawesome5.FontAwesomeRegular;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.fontelico.Fontelico;
import org.kordamp.ikonli.foundation.Foundation;
import org.kordamp.ikonli.hawconsfilled.HawconsFilled;
import org.kordamp.ikonli.hawconsstroke.HawconsStroke;
import org.kordamp.ikonli.icomoon.Icomoon;
import org.kordamp.ikonli.ionicons.Ionicons;
import org.kordamp.ikonli.ionicons4.Ionicons4IOS;
import org.kordamp.ikonli.ionicons4.Ionicons4Logo;
import org.kordamp.ikonli.ionicons4.Ionicons4Material;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.ligaturesymbols.LigatureSymbols;
import org.kordamp.ikonli.linecons.Linecons;
import org.kordamp.ikonli.maki.Maki;
import org.kordamp.ikonli.maki2.Maki2;
import org.kordamp.ikonli.mapicons.Mapicons;
import org.kordamp.ikonli.material.Material;
import org.kordamp.ikonli.materialdesign.MaterialDesign;
import org.kordamp.ikonli.metrizeicons.MetrizeIcons;
import org.kordamp.ikonli.ociicons.Ociicons;
import org.kordamp.ikonli.octicons.Octicons;
import org.kordamp.ikonli.openiconic.Openiconic;
import org.kordamp.ikonli.paymentfont.PaymentFont;
import org.kordamp.ikonli.runestroicons.Runestroicons;
import org.kordamp.ikonli.themify.Themify;
import org.kordamp.ikonli.typicons.Typicons;
import org.kordamp.ikonli.weathericons.WeatherIcons;
import org.kordamp.ikonli.websymbols.Websymbols;
import org.kordamp.ikonli.zondicons.Zondicons;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.EnumSet.allOf;

public class IkonSet {

    //AllIkons
    public static final List<FontIcon> DASHICONS = GetAllIkonsByType(Dashicons.class, allOf(Dashicons.class));
    public static final List<FontIcon> DEVICONS = GetAllIkonsByType(Devicons.class, allOf(Devicons.class));
    public static final List<FontIcon> ELUSIVE_ICONS = GetAllIkonsByType(Elusive.class, allOf(Elusive.class));
    public static final List<FontIcon> ENTYPO_ICONS = GetAllIkonsByType(Entypo.class, allOf(Entypo.class));
    public static final List<FontIcon> FEATHER_ICONS = GetAllIkonsByType(Feather.class, allOf(Feather.class));
    public static final List<FontIcon> FONTAWESOME_ICONS = GetAllIkonsByType(FontAwesome.class, allOf(FontAwesome.class));
    public static final List<FontIcon> FONTAWESOME_BRANDS_ICONS = GetAllIkonsByType(FontAwesomeBrands.class, allOf(FontAwesomeBrands.class));
    public static final List<FontIcon> FONTAWESOME_SOLID_ICONS = GetAllIkonsByType(FontAwesomeSolid.class, allOf(FontAwesomeSolid.class));
    public static final List<FontIcon> FONTAWESOME_REGULAR_ICONS = GetAllIkonsByType(FontAwesomeRegular.class, allOf(FontAwesomeRegular.class));
    public static final List<FontIcon> FONTELICO_ICONS = GetAllIkonsByType(Fontelico.class, allOf(Fontelico.class));
    public static final List<FontIcon> FOUNDATION_ICONS = GetAllIkonsByType(Foundation.class, allOf(Foundation.class));
    public static final List<FontIcon> HAWCONS_FILLED_ICONS = GetAllIkonsByType(HawconsFilled.class, allOf(HawconsFilled.class));
    public static final List<FontIcon> HAWCONS_STROKE_DESIGN_ICONS = GetAllIkonsByType(HawconsStroke.class, allOf(HawconsStroke.class));
    public static final List<FontIcon> ICOMOON = GetAllIkonsByType(Icomoon.class, allOf(Icomoon.class));
    public static final List<FontIcon> IONICONS4_MATERIAL_ICONS = GetAllIkonsByType(Ionicons4Material.class, allOf(Ionicons4Material.class));
    public static final List<FontIcon> IONICONS4_IOS_ICONS = GetAllIkonsByType(Ionicons4IOS.class, allOf(Ionicons4IOS.class));
    public static final List<FontIcon> IONICONS4_LOGO_ICONS = GetAllIkonsByType(Ionicons4Logo.class, allOf(Ionicons4Logo.class));
    public static final List<FontIcon> IONICONS = GetAllIkonsByType(Ionicons.class, allOf(Ionicons.class));
    public static final List<FontIcon> LIGATURE_SYMBOLS = GetAllIkonsByType(LigatureSymbols.class, allOf(LigatureSymbols.class));
    public static final List<FontIcon> LINECONS = GetAllIkonsByType(Linecons.class, allOf(Linecons.class));
    public static final List<FontIcon> MAKI_ICONS = GetAllIkonsByType(Maki.class, allOf(Maki.class));
    public static final List<FontIcon> MAKI2_ICONS = GetAllIkonsByType(Maki2.class, allOf(Maki2.class));
    public static final List<FontIcon> MAPICONS = GetAllIkonsByType(Mapicons.class, allOf(Mapicons.class));
    public static final List<FontIcon> MATERIAL_ICONS = GetAllIkonsByType(Material.class, allOf(Material.class));
    public static final List<FontIcon> MATERIAL_DESIGN_ICONS = GetAllIkonsByType(MaterialDesign.class, allOf(MaterialDesign.class));
    public static final List<FontIcon> METRIZE_ICONS = GetAllIkonsByType(MetrizeIcons.class, allOf(MetrizeIcons.class));
    public static final List<FontIcon> OCIICONS = GetAllIkonsByType(Ociicons.class, allOf(Ociicons.class));
    public static final List<FontIcon> OCTICONS = GetAllIkonsByType(Octicons.class, allOf(Octicons.class));
    public static final List<FontIcon> OPENICONIC = GetAllIkonsByType(Openiconic.class, allOf(Openiconic.class));
    public static final List<FontIcon> PAYMENT_FONTS = GetAllIkonsByType(PaymentFont.class, allOf(PaymentFont.class));
    public static final List<FontIcon> RUNESTROICONS = GetAllIkonsByType(Runestroicons.class, allOf(Runestroicons.class));
    public static final List<FontIcon> THEMIFY_ICONS = GetAllIkonsByType(Themify.class, allOf(Themify.class));
    public static final List<FontIcon> TYPICONS = GetAllIkonsByType(Typicons.class, allOf(Typicons.class));
    public static final List<FontIcon> WEATHER_ICONS = GetAllIkonsByType(WeatherIcons.class, allOf(WeatherIcons.class));
    public static final List<FontIcon> WEBSYMBOLS = GetAllIkonsByType(Websymbols.class, allOf(Websymbols.class));
    public static final List<FontIcon> ZONDICONS = GetAllIkonsByType(Zondicons.class, allOf(Zondicons.class));


    public static List<FontIcon> AllIkons() {

        return Stream.of(DASHICONS, MAKI2_ICONS, ZONDICONS, WEBSYMBOLS, WEATHER_ICONS, TYPICONS, THEMIFY_ICONS, RUNESTROICONS, PAYMENT_FONTS,
                OPENICONIC, OCTICONS, OCIICONS, METRIZE_ICONS, MATERIAL_DESIGN_ICONS, MATERIAL_ICONS, MAPICONS, MAKI_ICONS, LINECONS,
                LIGATURE_SYMBOLS, IONICONS, DEVICONS, ELUSIVE_ICONS, ENTYPO_ICONS, FEATHER_ICONS, FONTAWESOME_ICONS, FONTAWESOME_BRANDS_ICONS,
                FONTAWESOME_SOLID_ICONS, FONTAWESOME_REGULAR_ICONS, FONTELICO_ICONS, FOUNDATION_ICONS, HAWCONS_FILLED_ICONS,
                HAWCONS_STROKE_DESIGN_ICONS, ICOMOON, IONICONS4_MATERIAL_ICONS, IONICONS4_IOS_ICONS, IONICONS4_LOGO_ICONS
        ).flatMap(Collection::stream).collect(Collectors.toList());
    }

    public static List<FontIcon> GetAllIkonsByType(Class<? extends Ikon> iconFontClass, EnumSet<? extends Ikon> enumSet) {

        List<FontIcon> fontIcons = new ArrayList<>();


        for (Ikon value : enumSet) {
            FontIcon icon = FontIcon.of(value);
            icon.getStyleClass().setAll("font-icon");
            fontIcons.add(icon);
        }

        return fontIcons;
    }

    public static Map<String, List<FontIcon>> allIkonsMap() {

        List<FontIcon> allFontIcons = AllIkons();

        return allFontIcons
                .stream()
                .collect(Collectors.groupingBy(fontIcon -> fontIcon.getIconCode().getClass().getSimpleName()));
    }
}









